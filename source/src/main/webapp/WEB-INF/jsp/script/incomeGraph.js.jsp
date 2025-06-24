<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
let targetIncome = 0;

let yearlyData = {	
		  2024: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		  2025: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		  2026: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		  2027: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		  2028: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		  2029: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		  2030: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		  2031: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		  2032: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		  2033: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		};

<c:forEach var="e" items="${mInfo}" >
	<c:set var="year" value="${e.workMonth.split('-')[0]}" /> 
	<c:set var="tuki" value="${e.workMonth.split('-')[1]}" /> 
	yearlyData[${year}][${tuki-1}]=${e.estimatedMonthlyIncome};
	
</c:forEach>

<c:forEach var="e" items="${mIncome}" >
targetIncome=Math.floor(${e.gIncome /12});

</c:forEach>




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
            //borderDash: [10, 10],
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
                    let lines = ["収入:"+ "￥" +yearlyData[2025][10]];
                    if (value >= targetIncome) {
                    lines.push('🎉 達成!!!');  // 2行目に追加
                    }
                    return lines;
                } else {
                    return ["目標:"+ "￥" +targetIncome];
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
  document.getElementById('year-label').textContent = currentYear + "年";
  if (incomeChart) {
    incomeChart.destroy();
  }
  createChart(currentYear);
}

window.addEventListener('DOMContentLoaded', () => {
  createChart(currentYear);
});

</script>