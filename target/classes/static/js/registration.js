document.addEventListener('DOMContentLoaded', function() {
    const registrationForm = document.getElementById('registrationForm');
    if (registrationForm) {
        registrationForm.addEventListener('submit', async function(event) {
            event.preventDefault();

            const formData = {
                name: this.name.value,
                email: this.email.value,
                password: this.password.value,
                role: getSelectedRole() 
            };

            try {
                const response = await fetch('/rest-api/user/v1/register', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(formData)
                });

                if (response.ok) {
                    window.location.href = '/';
                } else {
                    const error = await response.text();
                    document.getElementById('message').innerText = 'Registration failed: ' + error;
                }
            } catch (error) {
                document.getElementById('message').innerText = 'Error: ' + error.message;
            }
        });
    } else {
        console.error("Registration form not found");
    }
});

function getSelectedRole() {
    const roleRadios = document.querySelectorAll('input[name="role"]');
    for (const radio of roleRadios) {
        if (radio.checked) {
            return radio.value;
        }
    }
    return null;
}