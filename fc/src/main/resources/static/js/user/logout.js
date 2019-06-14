function logout() {
   var username= sessionStorage.removeItem('username');
    // window.location.href="index.html";
   if (username==null){
       alert("退出成功");
   }
}