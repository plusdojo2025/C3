function calculateCalories() {
  const sections = ['m', 'n', 'e', 'snack'];
  sections.forEach(prefix => {
    let total = 0;

    // それぞれの選択肢（主食・主菜・副菜・その他）を取得
    ['Staple', 'Main', 'Side', 'Other'].forEach(type => {
      const selected = document.querySelector(`input[name="${prefix}${type}"]:checked`);
      if (selected && selected.dataset.calorie) {
        total += parseInt(selected.dataset.calorie);
      }
    });

    // 間食（snack）は prefix = 'snack' で nameも 'snack'
    if (prefix === 'snack') {
      const snack = document.querySelector(`input[name="snack"]:checked`);
      if (snack && snack.dataset.calorie) {
        total = parseInt(snack.dataset.calorie);
      }
    }

    // 表示更新
    const target = document.getElementById(`${prefix}Total`);
    if (target) target.textContent = total + ' kcal';
  });
}

// ページロード時にも一度計算
window.addEventListener('DOMContentLoaded', () => {
  calculateCalories();
  document.querySelectorAll('input[type="radio"]').forEach(input => {
    input.addEventListener('change', calculateCalories);
  });
});