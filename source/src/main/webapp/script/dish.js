  // ダミーデータ（7日分 × 4食）
  const mealData = [
    ["日曜の朝", "日曜の昼", "日曜の晩", "日曜の間食"],
    ["月曜の朝", "月曜の昼", "月曜の晩", "月曜の間食"],
    ["火曜の朝", "火曜の昼", "火曜の晩", "火曜の間食"],
    ["水曜の朝", "水曜の昼", "水曜の晩", "水曜の間食"],
    ["木曜の朝", "木曜の昼", "木曜の晩", "木曜の間食"],
    ["金曜の朝", "金曜の昼", "金曜の晩", "金曜の間食"],
    ["土曜の朝", "土曜の昼", "土曜の晩", "土曜の間食"]
  ];

  const weekDays = ["日", "月", "火", "水", "木", "金", "土"];

  const dateButtonsContainer = document.getElementById("date-buttons");
  const prevWeekBtn = document.getElementById("prev-week");
  const nextWeekBtn = document.getElementById("next-week");

  const contentMorning = document.getElementById("content-morning");
  const contentLunch   = document.getElementById("content-lunch");
  const contentDinner  = document.getElementById("content-dinner");
  const contentSnack   = document.getElementById("content-snack");

  const today = new Date();
  let currentWeekOffset = 0;

  // 曜日付きで日付表示を返す
  function formatDate(date) {
    const month = date.getMonth() + 1;
    const day   = date.getDate();
    const wday  = weekDays[date.getDay()];
    return `${month}/${day}（${wday}）`;
  }

  //一週間の食事内容の表示
  function renderWeek() {
    dateButtonsContainer.innerHTML = "";

    const baseDate = new Date(today);
    baseDate.setDate(baseDate.getDate() + currentWeekOffset * 7);

    // 日曜始まり
    const sunday = new Date(baseDate);
    sunday.setDate(baseDate.getDate() - baseDate.getDay());

    for (let i = 0; i < 7; i++) {
      const date = new Date(sunday);
      date.setDate(sunday.getDate() + i);

      const btn = document.createElement("button");
      btn.textContent = formatDate(date);
      btn.addEventListener("click", () => {
        showMealContent(i);  // インデックスで対応
      });

      dateButtonsContainer.appendChild(btn);

      // 本日なら初期選択
      if (
        date.getDate() === today.getDate() &&
        date.getMonth() === today.getMonth() &&
        date.getFullYear() === today.getFullYear()
      ) {
        showMealContent(i);
      }
    }
  }

  //朝昼晩間食の内容を表示する
  function showMealContent(index) {
    contentMorning.textContent = mealData[index][0];
    contentLunch.textContent   = mealData[index][1];
    contentDinner.textContent  = mealData[index][2];
    contentSnack.textContent   = mealData[index][3];
  }

  //前の週のナビゲーション
  prevWeekBtn.addEventListener("click", () => {
    currentWeekOffset--;
    renderWeek();
  });

  //次の週のナビゲーション
  nextWeekBtn.addEventListener("click", () => {
    currentWeekOffset++;
    renderWeek();
  });

  // 初期表示
  renderWeek();

 
 