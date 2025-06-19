 //グラフを描写
 const ctx = document.getElementById('weightChart').getContext('2d');

    let viewMode = 'monthly'; // 表示モード
    let currentMonth = new Date().getMonth(); // 現在の月
    let currentYear = new Date().getFullYear(); // 現在の年

    // 月別データを生成（指定した年と月のデータ）
    function generateMonthlyData(year, month) {
      const daysInMonth = new Date(year, month + 1, 0).getDate(); //指定月の日数を取得
      const labels = Array.from({ length: daysInMonth }, (_, i) => `${i + 1}日`); //ラベルの表示
      const actual = Array.from({ length: daysInMonth }, () => Math.floor(Math.random() * 5) + 60); //日数分の実際体重データ生成
      const target = Array(daysInMonth).fill(62); //日数分の目標体重データ生成
      return { labels, actual, target }; 
    }

    // 年別データを生成（指定した年のデータ）
    function generateYearlyData(year) {
      const labels = Array.from({ length: 12 }, (_, i) => `${i + 1}月`); //ラベルの表示
      const actual = Array.from({ length: 12 }, () => Math.floor(Math.random() * 5) + 60); //月数分の実際体重データ生成
      const target = Array(12).fill(62); //日数分の目標体重データ生成
      return { labels, actual, target };
    }

    let chart;

    //グラフの描写
    function renderChart() {
      let dataObj;

      // 切替ボタンを押したときの分岐処理
      if (viewMode === 'monthly') {
        document.getElementById('monthly-controls').style.display = 'block'; //月別ボタン操作を表示
        document.getElementById('yearly-controls').style.display = 'none'; //年別ボタン操作を非表示
        dataObj = generateMonthlyData(currentYear, currentMonth); //選択中の年・月のデータを生成
        document.getElementById('month-label').textContent = `${currentYear}年${currentMonth + 1}月`; //現在の月を示すラベルを表示
      } else {
        document.getElementById('monthly-controls').style.display = 'none'; //月別ボタン操作を非表示
        document.getElementById('yearly-controls').style.display = 'block'; //年別ボタン操作を表示
        dataObj = generateYearlyData(currentYear); //選択中の年の12ヶ月分のデータを生成。
        document.getElementById('year-label').textContent = `${currentYear}年`; //現在の年を示すラベルを表示
      }

      if (chart) chart.destroy(); // 既存のグラフを破棄
      
      //新しいグラフの生成
      chart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: dataObj.labels, // X軸ラベル
          datasets: [
            {
              label: '実際の体重',
              data: dataObj.actual,
              borderColor: 'rgb(101, 182, 253)',
              fill: false,
              /*pointBackgroundColor: dataObj.actual.map((v, i) => v < dataObj.target[i] ? 'rgb(148, 203, 252)' : 'rgb(148, 203, 252)'),*/
              pointRadius: 3,
              pointHoverRadius: 5,
            },
            {
              label: '目標体重',
              data: dataObj.target,
              borderColor: 'rgb(253, 155, 106)',
              //borderDash: [10, 10],
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
                  const index = context.dataIndex; //ホバー箇所を取得
                  const actual = context.chart.data.datasets[0].data[index]; //indexと同じ位置の実際体重を取得
                  const target = context.chart.data.datasets[1].data[index]; //indexと同じ位置の目標体重を取得
                  const label = `${context.dataset.label}: ${actual}kg`;
                  return actual < target ? [label, '🎉 達成!!!'] : label;
                }
              }
            },
            legend: {
              display: true,
              labels: {
      			font: {
        			size: 16  // ここで凡例の文字を大きく
      				}
    			},
              position: 'bottom'
            }
          }
        }
      });
    }

    // 表示モードを月別に切り替える
    function switchToMonthly() {
      viewMode = 'monthly';
      renderChart();
    }

    // 表示モードを年別に切り替える
    function switchToYearly() {
      viewMode = 'yearly';
      renderChart();
    }

    // 月を変更（前後に移動）
    function changeMonth(offset) {
      currentMonth += offset;
      if (currentMonth < 0) {
        currentMonth = 11;
        currentYear--;
      } else if (currentMonth > 11) {
        currentMonth = 0;
        currentYear++;
      }
      renderChart();
    }
    
    // 年を変更（前後に移動）
    function changeYear(offset) {
      currentYear += offset;
      renderChart();
    }

    renderChart();