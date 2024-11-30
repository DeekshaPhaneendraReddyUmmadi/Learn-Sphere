// document.getElementById('login').addEventListener('submit', async function(event) {
//     event.preventDefault();

//     const formData = {
//         email: this.email.value,
//         password: this.password.value,
//     };

//     try {
//         const response = await fetch('/user/login', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify(formData)
//         });

//         if (response.ok) {
//             const result = await response.text();
            
//             window.location.href = '/student';
//         } else {
//             const error = await response.text();
//             document.getElementById('message').innerText = 'Registration failed: ' + error; // Display error message
//         }
//     } catch (error) {
//         document.getElementById('message').innerText = 'Error: ' + error.message; // Handle network errors
//     }
// });
