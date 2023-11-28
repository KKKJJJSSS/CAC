function showToast() {
    var toast = new bootstrap.Toast(document.querySelector('.toast'));
    toast.show();
}

window.addEventListener('DOMContentLoaded', function() {
    showToast();
});
