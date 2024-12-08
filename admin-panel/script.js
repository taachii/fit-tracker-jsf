// Funkcje do dynamicznego ładowania treści w zależności od wybranego linku
document.getElementById('trainerLink').addEventListener('click', function() {
  document.getElementById('content').innerHTML = "<h2>Mój trener</h2><p>Informacje o Twoim trenerze będą tutaj.</p>";
});

document.getElementById('notesLink').addEventListener('click', function() {
  document.getElementById('content').innerHTML = "<h2>Notatki</h2><p>Twoje notatki zostaną wyświetlone tutaj.</p>";
});

document.getElementById('statsLink').addEventListener('click', function() {
  document.getElementById('content').innerHTML = "<h2>Statystyki</h2><p>Twoje statystyki zostaną tutaj wyświetlone.</p>";
});

document.getElementById('availableTrainersLink').addEventListener('click', function() {
  document.getElementById('content').innerHTML = "<h2>Dostępni trenerzy</h2><p>Lista dostępnych trenerów pojawi się tutaj.</p>";
});

// Kliknięcie na nazwę użytkownika rozwija menu
document.getElementById('userInfo').addEventListener('click', function(event) {
  this.classList.toggle('active');
  event.stopPropagation(); // Zapobiega zamknięciu menu po kliknięciu na nazwę użytkownika
});

// Kliknięcie gdziekolwiek (nawet wewnątrz sub-menu) zamyka sub-menu
document.addEventListener('click', function() {
  const userInfo = document.getElementById('userInfo');
  userInfo.classList.remove('active');
});
