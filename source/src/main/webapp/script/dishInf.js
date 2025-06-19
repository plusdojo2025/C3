    // 現在日時を「YYYY-MM-DD HH:mm:ss」形式で取得
     function getCurrentDate() {
        const now = new Date();
        const year = now.getFullYear();
        const month = String(now.getMonth() + 1).padStart(2, '0'); // 月は0始まり
        const day = String(now.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    }

    // ページ読み込み時に現在日時をセット
    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("date").value = getCurrentDate();
    });
