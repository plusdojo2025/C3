<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
document.addEventListener("DOMContentLoaded", function () {

  const weekDays = ["日", "月", "火", "水", "木", "金", "土"];
  const dateButtonsContainer = document.getElementById("date-buttons");
  const prevWeekBtn = document.getElementById("prev-week");
  const nextWeekBtn = document.getElementById("next-week");
  const contentMorning = document.getElementById("content-morning");
  const contentLunch = document.getElementById("content-lunch");
  const contentDinner = document.getElementById("content-dinner");
  const contentSnack = document.getElementById("content-snack");

  const today = new Date();
  let currentWeekOffset = 0;

  function formatDate(date) {
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const wday = weekDays[date.getDay()];
    return month+"/"+day+"（"+wday+"）";
  }

  function formatISODate(date) {
    return date.toISOString().split('T')[0]; // yyyy-mm-dd
  }

  function renderWeek() {
    dateButtonsContainer.innerHTML = "";
    const baseDate = new Date(today);
    baseDate.setDate(baseDate.getDate() + currentWeekOffset * 7);
    const sunday = new Date(baseDate);
    sunday.setDate(baseDate.getDate() - baseDate.getDay());

    for (let i = 0; i < 7; i++) {
      const date = new Date(sunday);
      date.setDate(sunday.getDate() + i);

      const btn = document.createElement("button");
      btn.textContent = formatDate(date);
      btn.classList.add("date-button");
      btn.addEventListener("click", () => {
        //fetchMealData(formatISODate(date));
        location.href = "?ymd="
        		+date.getFullYear()
        		+"-"+(date.getMonth()+1).toString().padStart(2,"0")
        		+"-"+(date.getDate()).toString().padStart(2,"0");
        highlightSelectedDate(btn);
      });

      dateButtonsContainer.appendChild(btn);

      if (
        date.getDate() === today.getDate() &&
        date.getMonth() === today.getMonth() &&
        date.getFullYear() === today.getFullYear()
      ) {
        //fetchMealData(formatISODate(date));
        highlightSelectedDate(btn);
      }
    }
  }

  function highlightSelectedDate(selectedBtn) {
    document.querySelectorAll(".date-button").forEach(btn => {
      btn.classList.remove("selected-date");
    });
    selectedBtn.classList.add("selected-date");
  }

  function fetchMealData(dateStr) {
	  fetch(`DishMakan?date=${dateStr}`, {
	    headers: {
	      "X-Requested-With": "XMLHttpRequest"  // ★これが超重要
	    }
	  })
	    .then(response => response.json())
	    .then(data => {
	      contentMorning.innerHTML = data[0] ? `${data[0].name} (${data[0].calorie} kcal)` : "データなし";
	      contentLunch.innerHTML = data[1] ? `${data[1].name} (${data[1].calorie} kcal)` : "データなし";
	      contentDinner.innerHTML = data[2] ? `${data[2].name} (${data[2].calorie} kcal)` : "データなし";
	      contentSnack.innerHTML = data[3] ? `${data[3].name} (${data[3].calorie} kcal)` : "データなし";
	    })
	    .catch(error => {
	      console.error(error);
	      contentMorning.innerHTML =
	        contentLunch.innerHTML =
	        contentDinner.innerHTML =
	        contentSnack.innerHTML = "エラー発生";
	    });
	}
  
  prevWeekBtn.addEventListener("click", () => {
    currentWeekOffset--;
    renderWeek();
  });

  nextWeekBtn.addEventListener("click", () => {
    currentWeekOffset++;
    renderWeek();
  });

  renderWeek();
});

document.getElementById("select-link").onclick = function() {
	 if (confirm("１日１回しか登録できません")){
     	alert("食事選択画面に移動します");
     	return true;
     }
     else{
     	alert("キャンセルしました");
     	return false;
     }
}
</script>