import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';
import './CreatePost.css'; // Create a CreatePost.css file for styling

const CreatePost = () => {
  const { username } = useParams();
  const navigate = useNavigate();

  const [postdata, setPostData] = useState('');

  const submitPost = async () => {
    try {
      const response = await axios.post('http://localhost:9090/createpost', {
        username: username,
        postData: postdata,
      });
      console.log(response);
    } catch (error) {
      console.error(error);
    }

    navigate(`/home/${username}`);
  };

  return (
    <div className="create-post-container">
      <div className="create-post-heading">Add Your Post</div>
      <textarea
        className="post-textarea"
        placeholder="Write your post here"
        value={postdata}
        onChange={(e) => {
          setPostData(e.target.value);
        }}
      />

      <div>
        <button className="submit-button" onClick={submitPost}>
          Submit
        </button>
      </div>

      <div className="login-footer">
        <div>Created By:</div>
        <div className="user-name">Harsh Sharma</div>
        <div className="linkedin-link">
          <a
            href="https://www.linkedin.com/in/harsh-sharma-11dec1995/"
            target="_blank"
            rel="noopener noreferrer"
          >
            LinkedIn Profile
          </a>
        </div>
      </div>
    </div>
  );
};

export default CreatePost;
