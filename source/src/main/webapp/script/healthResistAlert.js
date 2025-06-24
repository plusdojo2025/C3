/**
 * 
 */
 'use strict';
 
 function validateWeightLoss() {
  // 値の取得
  const iWeight = document.querySelector('input[name="iWeight"]').value.trim();
  const cWeight = document.querySelector('input[name="cWeight"]').value.trim();
  const height = document.querySelector('input[name="height"]').value.trim();
  const age = document.querySelector('input[name="age"]').value.trim();
  const gender = document.querySelector('input[name="gender"]:checked'); // ラジオボタンはcheckedが必要
  const term = document.querySelector('input[name="term"]').value.trim();
  const wMotionDays = document.querySelector('input[name="wMotionDays"]').value.trim();

  // 入力必須チェック
  if (!iWeight || !cWeight || !height || !age || !gender || !term || !wMotionDays) {
    alert("すべての項目を入力してください。");
    return false;
  }
  
  // ダイエットペース計算
  const weightLoss = cWeight - iWeight;
  const monthlyLoss = weightLoss / (term / 30);
  const threshold = cWeight * 0.05;
  
// 条件分岐
  if (monthlyLoss > threshold) {
    alert("1ヶ月あたりの体重減少が現在の体重の5%を超えています。\n健康を損なうおそれがあるため、目指す体重、期間の入力内容を見直してください。");
    return false;
  }

  return true;
}
