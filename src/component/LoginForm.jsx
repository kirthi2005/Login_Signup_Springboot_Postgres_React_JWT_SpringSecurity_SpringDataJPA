import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
    
function LoginForm() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (event) => {
        event.preventDefault();

        const loginData = {username, password};
        console.log("Requested Data: " + loginData.username);
        console.log("Requested Data: " + loginData.password);

// For Login - Post request
    try{
        const responseData =  fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
        },
        body: JSON.stringify(loginData),
        })
        .then(response => response.text())
        .then(data => console.log(data))
    }
        catch(error){ console.error('Error:', error)};
}

    return (
        <form onSubmit={handleSubmit}>
           <div className="login-container">
           <div className="login-form">
            <h3> Login </h3>
            <div>
                <input type="text" placeholder="Username" value={username} onChange={(e) => setUsername(e.target.value)} />
            </div>
            <div>
                <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} />
            </div>
            <div>
            <button type="submit" style={{marginRight: "5px"}}>Login </button>
            <div>
               New User? <button type="button" onClick={() => navigate("/register")}>Register</button>
               </div>
            </div>
        </div>
        </div>
           
        </form>
    );
}

export default LoginForm;
