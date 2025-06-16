<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>食事表示</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<!-- フッターここから -->
<!-- フッターここまで -->

    <%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
  // 遷移先のサーブレットURLを定義
  String servletURL = "DishInfMakan";
%>

  <!-- 日付 -->
  <button id="prev-week">◀ 前の週</button>
  <div id="date-buttons"></div>
  <button id="next-week">次の週 ▶</button>

  <!-- 食事が表示される場所 -->
  <main>
    <div id="content">
      <div id="tabs"></div>
      <div id="tab-content">ここに内容が表示されます</div>
      <a href="DishInfMakan">選択</a>
    </div>
  </main>

  <!-- トラ画像 -->
  <img src="images/tora.png">

  <!-- 一日の消費カロリー -->
  <p>今日の消費カロリー</p>
  <p>〇kcal</p>

  <!-- JavaScript -->
  <script>
    const servletURL = "DishMakan"; // JSPからサーブレットURL取得

    const contents = [
      ["1日目の朝", "1日目の昼", "1日目の晩", "1日目の間食"],
      ["2日目の朝", "2日目の昼", "2日目の晩", "2日目の間食"],
      ["3日目の朝", "3日目の昼", "3日目の晩", "3日目の間食"],
      ["4日目の朝", "4日目の昼", "4日目の晩", "4日目の間食"],
      ["5日目の朝", "5日目の昼", "5日目の晩", "5日目の間食"],
      ["6日目の朝", "6日目の昼", "6日目の晩", "6日目の間食"],
      ["7日目の朝", "7日目の昼", "7日目の晩", "7日目の間食"]
    ];

    const labels = ["朝", "昼", "晩", "間食"];

    const dateButtonsContainer = document.getElementById("date-buttons");
    const tabsContainer = document.getElementById("tabs");
    const tabContent = document.getElementById("tab-content");
    const prevWeekBtn = document.getElementById("prev-week");
    const nextWeekBtn = document.getElementById("next-week");

    const today = new Date();
    let currentWeekOffset = 0;

    function renderWeek() {
      dateButtonsContainer.innerHTML = "";
      let todayIndex = -1;

      const baseDate = new Date(today);
      baseDate.setDate(baseDate.getDate() + currentWeekOffset * 7);

      const dayOfWeek = baseDate.getDay();
      const sunday = new Date(baseDate);
      sunday.setDate(baseDate.getDate() - dayOfWeek);

      for (let i = 0; i < 7; i++) {
        const date = new Date(sunday);
        date.setDate(sunday.getDate() + i);

        const mm = date.getMonth() + 1;
        const dd = date.getDate();
        const weekDay = ["日", "月", "火", "水", "木", "金", "土"][date.getDay()];
        const dateStr = `${mm}/${dd}（${weekDay}）`;

        const button = document.createElement("button");
        button.className = "date-button";
        button.textContent = dateStr;

        button.addEventListener("click", () => {
          showAllContentsForDay(i, dateStr);
        });

        dateButtonsContainer.appendChild(button);

        if (
          date.getDate() === today.getDate() &&
          date.getMonth() === today.getMonth() &&
          date.getFullYear() === today.getFullYear()
        ) {
          todayIndex = i;
        }
      }

      const selectedIndex = todayIndex >= 0 ? todayIndex : 0;
      const selDate = new Date(sunday);
      selDate.setDate(sunday.getDate() + selectedIndex);
      const mm = selDate.getMonth() + 1;
      const dd = selDate.getDate();
      const weekDay = ["日", "月", "火", "水", "木", "金", "土"][selDate.getDay()];
      const dateStr = `${mm}/${dd}（${weekDay}）`;

      showAllContentsForDay(selectedIndex, dateStr);
    }

    prevWeekBtn.addEventListener("click", () => {
      currentWeekOffset--;
      renderWeek();
    });

    nextWeekBtn.addEventListener("click", () => {
      currentWeekOffset++;
      renderWeek();
    });

    function showAllContentsForDay(dayIndex, dateStr) {
      tabsContainer.innerHTML = "";
      tabContent.innerHTML = "";

      labels.forEach((label, index) => {
        const section = document.createElement("div");
        section.className = "meal-section";

        const title = document.createElement("h3");
        title.textContent = label;

        const body = document.createElement("div");
        body.innerHTML = `${contents[dayIndex][index]}`;

        const button = document.createElement("button");
        button.textContent = "選択";
        button.style.marginTop = "5px";

        const mealParam = encodeURIComponent(label);
        const dateParam = encodeURIComponent(dateStr);

        button.onclick = () => {
          window.location.href = `${servletURL}?meal=${mealParam}&date=${dateParam}`;
        };

        section.appendChild(title);
        section.appendChild(body);
        section.appendChild(button);
        tabContent.appendChild(section);
      });
    }

    renderWeek();
  </script>
  </body>
</html>
