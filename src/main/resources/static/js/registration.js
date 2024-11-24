// document.getElementById('registrationForm').addEventListener('submit', async function(event) {
//     event.preventDefault(); // Prevent the default form submission

//     // Collect form data
//     const formData = {
//         name: this.name.value.trim(), // Trim whitespace
//         email: this.email.value.trim(),
//         password: this.password.value
//     };

//     // Validate form data (basic validation)
//     if (!formData.name || !formData.email || !formData.password) {
//         document.getElementById('message').innerText = 'Please fill in all fields.'; // Display validation message
//         return; // Exit the function if validation fails
//     }

//     try {
//         // Send the form data to the server
//         const response = await fetch('/user/register', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify(formData)
//         });

//         // Check if the response is OK (status code 200-299)
//         if (response.ok) {
//             // Optionally, you can parse the response if needed
//             const result = await response.json(); // Assuming the server returns JSON
//             console.log('Registration successful:', result); // Log success for debugging

//             // Redirect to the home page or another page
//             window.location.href = '/';
//         } else {
//             // Handle server errors
//             const error = await response.json(); // Assuming the server returns JSON error
//             document.getElementById('message').innerText = 'Registration failed: ' + (error.message || 'Unknown error'); // Display error message
//         }
//     } catch (error) {
//         // Handle network errors
//         document.getElementById('message').innerText = 'Error: ' + error.message; // Display network error
//     }
// });



















document.getElementById('registrationForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const formData = {
        name: this.name.value,
        email: this.email.value,
        password: this.password.value,
        role: getSelectedRole() 
    };

    try {
        const response = await fetch('/user/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });

        if (response.ok) {
            const result = await response.text();
            
            window.location.href = '/';
        } else {
            const error = await response.text();
            document.getElementById('message').innerText = 'Registration failed: ' + error; // Display error message
        }
    } catch (error) {
        document.getElementById('message').innerText = 'Error: ' + error.message; // Handle network errors
    }
});


function getSelectedRole() {
    const roleRadios = document.querySelectorAll('input[name="role"]');
    for (const radio of roleRadios) {
        if (radio.checked) {
            return radio.value; // Return the value of the checked radio button
        }
    }
    return null; // Return null if no radio button is selected
}