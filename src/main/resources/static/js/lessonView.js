document.getElementById('comments-form').addEventListener('submit', async function(event) {
    event.preventDefault();

    let cmt = document.getElementById('cmt').value;
    let id = document.querySelector('tbody tr:first-child td:nth-child(1)').innerText;

    const formData = {
        cmt: cmt,
        lessonid: id
    };

    try {
        const response = await fetch('/rest-api/course/v1/addComment', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });

        if (response.ok) {
            const commentsSection = document.querySelector('.comments');
            const newCommentDiv = document.createElement('div');
            newCommentDiv.classList.add('comment');
            const newCommentText = document.createElement('p');
            newCommentText.innerText = cmt;
            newCommentDiv.appendChild(newCommentText);
            commentsSection.appendChild(newCommentDiv);
            document.getElementById('cmt').value = '';

        } else {
            const error = await response.text();
            document.getElementById('message').innerText = 'Registration failed: ' + error;
        }
    } catch (error) {
        document.getElementById('message').innerText = 'Error: ' + error.message;
    }
});