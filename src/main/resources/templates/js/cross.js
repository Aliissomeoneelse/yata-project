const express = require('express');
const cross = require('templates/js/cross');
const app = express();

// Allow requests from all origins during development (adjust this for production)
app.use(cross());

// ... other server configuration ...

app.listen(63342, () => {
    console.log('Server is running on http://localhost:63342');
});