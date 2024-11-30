document.getElementById('courseregister').addEventListener('submit', async function(event) {
    event.preventDefault();
    const formData = {
        courseId: document.getElementById('courseId').value,
        courseName: document.getElementById('courseName').value,
        coursePrice: document.getElementById('coursePrice').value,
    };
    

    try {
        const response = await fetch('/rest-api/course/v1/createCourse', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });

        if (response.ok) {
            alert("Course Added Successfully!");
            window.location.href = '/redirect';
        } else {
            const error = await response.text();
            document.getElementById('message').innerText = 'Registration failed: ' + error;
        }
    } catch (error) {
        document.getElementById('message').innerText = 'Error: ' + error.message;
    }
});