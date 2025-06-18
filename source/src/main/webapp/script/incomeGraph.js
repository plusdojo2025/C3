const targetIncome = 160000;

const yearlyData = {
  2024: [100000, 120000, 130000, 125000, 150000, 145000, 160000, 155000, 140000, 135000, 138000, 142000],
  2025: [120000, 150000, 135000, 140000, 160000, 155000, 170000, 165000, 158000, 175000, 168000, 172000],
  2026: [130000, 145000, 155000, 160000, 170000, 165000, 175000, 180000, 170000, 165000, 160000, 162000]
};

let currentYear = 2025;
let incomeChart;

function createChart(year) {
  const ctx = document.getElementById('incomeChart').getContext('2d');
  const months = ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'];
  const incomeData = yearlyData[year];
  
  //目標グラフの表示
  const targetLineData = new Array(12).fill(targetIncome);

  incomeChart = new Chart(ctx, {
         data: {
        labels: months,
        datasets: [
          {
            type: 'bar',
            label: '月別収入（円）',
            data: incomeData,
            backgroundColor: incomeData.map(value =>
              value >= targetIncome ? 'rgb(155, 208, 254)' : 'rgba(192, 192, 192, 0.7)'
            ),
            borderWidth: 1
          },
          {
            type: 'line',
            label: '目標金額',
            data: targetLineData,
            borderColor: 'rgb(249, 136, 80)',
            borderWidth: 2,
            borderDash: [10, 10],
            pointRadius: 0,
            fill: false
          }
        ]
      },
    options: {
      responsive: true,
      plugins: {
        tooltip: {
          backgroundColor: 'rgba(145, 145, 145, 0.9)', 
          padding: 12, // ← ツールチップ全体の余白を広くする
			  titleFont: {
			     size: 14,
			     weight: 'bold'
			  },
			  bodyFont: {
			     size: 14 // ← 本文（体重など）の文字サイズを上げる
			  },  
          callbacks: {
              label: function(context) {
                const value = context.raw;
                if (context.dataset.type === 'bar') {
                    const lines = [`収入: ¥${value.toLocaleString()}`];
                    if (value >= targetIncome) {
                    lines.push('🎉 達成!!!');  // 2行目に追加
                    }
                    return lines;
                } else {
                    return [`目標: ¥${value.toLocaleString()}`];
                }
                }
            }
        },
        legend: {
          labels: {
              filter: (legendItem, data) => {
                return data.datasets[legendItem.datasetIndex].type !== 'line';
              },
              font: {
        			size: 16  // ここで凡例の文字を大きく
      				}
    			},
              position: 'bottom'
            }
          }
        },
        scales: {
          y: {
            beginAtZero: true,
            ticks: {
              callback: function(value) {
                return '¥' + value.toLocaleString();
              }
            }
          }
        }
      }
    );
}
 
        

function changeYear(offset) {
  currentYear += offset;
  document.getElementById('year-label').textContent = `${currentYear}年`;
  if (incomeChart) {
    incomeChart.destroy();
  }
  createChart(currentYear);
}

window.addEventListener('DOMContentLoaded', () => {
  createChart(currentYear);
});