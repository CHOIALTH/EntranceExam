function loadEmployees() {
    const orderBy = document.getElementById('orderBy').value;

    fetch(`/employees?orderBy=${orderBy}`)
        .then(response => response.text())
        .then(data => {
            document.getElementById('employeeList').innerHTML = data;
        });
}

document.addEventListener('DOMContentLoaded', () => {
    loadEmployees();
});