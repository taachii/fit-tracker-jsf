// Kliknięcie na nazwę użytkownika rozwija menu
document.getElementById('userInfo').addEventListener('click', function(event) {
  this.classList.toggle('active');
  event.stopPropagation(); // Zapobiega zamknięciu menu po kliknięciu na nazwę użytkownika
});

// Kliknięcie gdziekolwiek zamyka sub-menu
document.addEventListener('click', function() {
  const userInfo = document.getElementById('userInfo');
  userInfo.classList.remove('active');
});
