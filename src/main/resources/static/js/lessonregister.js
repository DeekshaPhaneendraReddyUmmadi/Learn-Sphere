document.getElementById('lessonregister').addEventListener('submit', async function(event) {
    event.preventDefault();

    let lessonArray = document.getElementById('lessonName').value.split(',');

    const formData = {
        courseId: document.getElementById('courseId').value,
        lessonId: document.getElementById('lessonId').value,
        lessonName: lessonArray,
        lessonLink: document.getElementById('lessonLink').value,
        lessonTopics: document.getElementById('lessonTopics').value
    };
    
    try {
        const response = await fetch('/rest-api/course/v1/createLesson', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });

        if (response.ok) {
            alert("Lesson Added Successfully!");
            window.location.href = '/redirect';
        } else {
            const error = await response.text();
            document.getElementById('message').innerText = 'Registration failed: ' + error;
        }
    } catch (error) {
        document.getElementById('message').innerText = 'Error: ' + error.message;
    }
});