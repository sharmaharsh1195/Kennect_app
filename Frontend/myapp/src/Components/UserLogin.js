import "./UserLogin.css";
import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
import axios from 'axios';

const UserLogin = () => {
    const [username, setUsername] = useState('');
    const [emptyfield, setEmptyField] = useState('');
 
    const navigate = useNavigate();

    const handleLogin = async () => {
        if (username.trim() === '') {
            setEmptyField('Please enter your username first to enter');
            return;
        }

        try {
            const response = await axios.post('http://localhost:9090/adduser', {
                name: username,
            });
      
            if (response.status === 200) {
                
                navigate(`/home/${username}`);
            } else {
                
                console.error(response);
            }
        } catch (error) {
            console.error(error);
          
        }
    };

    return (
        <>
       <div className="assignment-text">
  Assignment for Software Developer Engineer Q&A_2023
</div>


        <div className="login-container">
            <h2>Login with Username</h2>
            {emptyfield && <div className="error-message">{emptyfield}</div>}
            <div className="input-container">
                <input
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
            </div>
            <div>
                <button onClick={handleLogin}>Login</button>
            </div>
        </div>
        <div className="login-footer">
          <div>Created By:</div>
                <div className="user-name">Harsh Sharma</div>
                <div className="linkedin-link">
                    <a href="https://www.linkedin.com/in/harsh-sharma-11dec1995/" target="_blank" rel="noopener noreferrer">
                        LinkedIn Profile
                    </a>
                </div>
                </div>


        
        </>
    );
};

export default UserLogin;
