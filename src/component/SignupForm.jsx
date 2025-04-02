import React, { useState } from 'react';

function SignupForm() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const[successMessage, setSuccessMessage] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    
    // Basic form validation for password match
    if (password !== confirmPassword) {
      setErrorMessage("Passwords don't match!");
      return;
    }

    setErrorMessage(''); // Reset error message
    setSuccessMessage('');

    const requestData = { username, password };
    console.log('Request Data:', requestData); // Log the request data for debugging

    try {
      const response =  await fetch('http://localhost:8080/auth/register', {
        method: 'POST',
        headers: {            
          'Content-Type': 'application/json',
          'Accept': 'application/json',          
        },
        body: JSON.stringify(requestData),
      });

      if (!response.ok) {
        throw new Error('HTTP error ' + response.status);
      }

      //const data = await response.json();  //error as it is expecting json
      //response.text() //as controller is sending text as user registered successfully.


      const data = response.text().then(function(text){ 
        console.log(text);
        setSuccessMessage(text);
    }); 
     

      // Optionally, clear the form on success
      setUsername('');
      setPassword('');
      setConfirmPassword('');
      
      
    } catch (error) {
      setErrorMessage('Error: ' + error.message);
      console.error('Error:', error);
    }
  }

  return (
    <form onSubmit={handleSubmit}>
      <div className="login-container">
        <div className="login-form">
          <h3>Register</h3>
          <div>
            <input
              type="text"
              placeholder="Username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
          </div>
          <div>
            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>
          <div>
            <input
              type="password"
              placeholder="Confirm Password"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
            />
          </div>
          <div>
          {errorMessage && <p style={{ color: 'red',margin:"15px" }}>{errorMessage}</p>}
          {successMessage && <p style={{ color: 'green',margin:"15px" }}>{successMessage}</p>}
          </div>
          <div>
            <button type="submit" style={{ marginRight: "5px" }}>Submit</button>
          </div>
        </div>
      </div>
    </form>
  );
}

export default SignupForm;



