window.addEventListener('DOMContentLoaded', event => {
  // Simple-DataTables
  // https://github.com/fiduswriter/Simple-DataTables/wiki
  // 這部分的程式碼檢查 datatablesSimple 變數是否存在，如果存在則使用 Simple-DataTables 函式庫的 DataTable 建構函式初始化一個新的數據表，並將 datatablesSimple 元素傳遞給它。這意味著這個數據表將應用到 id 為 "datatablesSimple" 的表格元素上。
  // 
  // 總   結來說，這段程式碼的目的是在 HTML 文件的 DOM 被完全載入和解析後，初始化一個數據表，該數據表將應用到 id 為 "datatablesSimple" 的表格元素上。

  const datatablesSimple = document.getElementById('datatablesSimple');
  if (datatablesSimple) {
    new simpleDatatables.DataTable(datatablesSimple);
  }
});
