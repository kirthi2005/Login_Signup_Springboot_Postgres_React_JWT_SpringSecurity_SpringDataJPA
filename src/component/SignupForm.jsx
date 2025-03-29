import React, { useState } from 'react';
    
function SignupForm() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
    
// For Post request
    try{
        
        const responseData =  fetch('http://localhost:8080/auth/register', {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json'
        },
        body: `username=${username}&password=${password}`,
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
            <h3> Register </h3>
            <div>
                <input type="text" placeholder="Username" value={username} onChange={(e) => setUsername(e.target.value)} />
            </div>
            <div>
                <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} />
            </div>
            <div>
                <input type="password" placeholder='confirm password' />
            </div>
            <div>
            <button type="submit" style={{marginRight: "5px"}}>Submit </button>            
           
            </div>
        </div>
        </div>
           
        </form>
    );
}

export default SignupForm;
