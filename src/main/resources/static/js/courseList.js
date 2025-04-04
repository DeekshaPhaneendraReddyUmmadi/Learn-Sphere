document.addEventListener("DOMContentLoaded", function() {
    const buyButtons = document.querySelectorAll('.buy-button');

    buyButtons.forEach(button => {
        button.addEventListener('click', function() {
            const courseId = this.getAttribute('data-courseid');

            const purchaseRequestDto = {
                courseId: courseId
            };

            fetch('/rest-api/course/v1/purchaseCourse', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(purchaseRequestDto)
            })
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error('Purchase failed: ' + response.statusText);
                }
            })
            .then(data => {
                alert(data);
            })
            .catch(error => {
                alert(error.message);
            });
        });
    });
});




// async function purchase(courseId) {
//     const formData = {
//         courseId: courseId // Change this to courseId
//     };

//     try {
//         const response = await fetch('/rest-api/course/v1/purchaseCourse', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify(formData)
//         });

//         if (response.ok) {
//             alert("Course Added Successfully!");
//             window.location.href = '/redirect';
//         } else {
//             const error = await response.text();
//             document.getElementById('message').innerText = 'Registration failed: ' + error;
//         }
//     } catch (error) {
//         document.getElementById('message').innerText = 'Error: ' + error.message;
//     }
// }

// document.querySelectorAll('.purchase-button').forEach(button => {
//     button.addEventListener('click', function(event) {
//         event.preventDefault();
//         const courseId = this.dataset.courseId;
//         purchase(courseId);
//     });
// });
























// async function purchase(courseId) {
//     const formData = {
//         courseId: courseId
//     };

//     try {
//         const response = await fetch('/rest-api/course/v1/purchaseCourse', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify(formData)
//         });

//         if (response.ok) {
//             alert("Course Added Successfully!");
//             window.location.href = '/redirect';
//         } else {
//             const error = await response.text();
//             document.getElementById('message').innerText = 'Registration failed: ' + error;
//         }
//     } catch (error) {
//         document.getElementById('message').innerText = 'Error: ' + error.message;
//     }
// }

// document.querySelectorAll('.purchase-button').forEach(button => {
//     button.addEventListener('click', function(event) {
//         event.preventDefault();
//         const courseId = this.dataset.courseId;
//         purchase(courseId);
//     });
// });
