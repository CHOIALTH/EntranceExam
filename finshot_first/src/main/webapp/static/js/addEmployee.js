function validateForm() {
    const phone = document.getElementById('phone');
    const email = document.getElementById('email');
    const phoneRegex = /^01[016789]-\d{3,4}-\d{4}$/;
    const emailRegex = /@/;

    if (!phoneRegex.test(phone.value)) {
        alert('Invalid phone format. Please use the format 010-1234-5678.');
        return false;
    }

    if (!emailRegex.test(email.value)) {
        alert('Invalid email format. Please include an @ in the email address.');
        return false;
    }

    return true;
}

document.getElementById('addEmplForm').addEventListener('submit', (event) => {
    if (!validateForm()) {
        event.preventDefault();
    }
});
