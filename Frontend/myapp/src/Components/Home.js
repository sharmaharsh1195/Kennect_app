import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
import './Home.css';
import SearchBar from './SearchBar';

const Home = () => {
  const { username } = useParams();
  const [posts, setPosts] = useState([]);
  const [comments, setComments] = useState([]);
  const [newcomment, setNewComment] = useState('');

  const [filteredPosts, setFilteredPosts] = useState([]);
  const [noResult, setNoResult] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const postsResponse = await axios.get('http://localhost:9090/posts');
        setPosts(postsResponse.data);

        const commentsResponse = await axios.get('http://localhost:9090/comments');
        setComments(commentsResponse.data);
      } catch (err) {
        console.error(err);
      }
    };

    fetchData();
  }, [newcomment]);

  const getAllComments = async () => {
    try {
      const response = await axios.get('http://localhost:9090/comments');
      setComments(response.data);
    } catch (err) {
      console.error(err);
    }
  };

  const showpost = async () => {
    try {
      const response = await axios.get('http://localhost:9090/posts');
      setPosts(response.data);
    } catch (err) {
      console.error(err);
    }
    getAllComments();
  };

  const createPost = () => {
    navigate(`/createpost/${username}`);
  };

  const addcomment = async (postid) => {
    try {
      await axios.post('http://localhost:9090/addcomment', {
        postId: postid,
        text: newcomment,
        username: username,
      });

      setNewComment('');
    } catch (err) {
      console.error(err);
    }
    getAllComments();
  };

  const handleSearch = (searchText) => {
    const filtered = posts.filter((post) =>
      post.post_data.toLowerCase().includes(searchText.toLowerCase())
    );

    setFilteredPosts(filtered);
    setNoResult(filtered.length === 0);
  };

  return (
    <div>
      <div className="container">
        <div className="home-page-text">Welcome To Kennect Technologies Home PAGE</div>
        <div className="welcome-text">
          Welcome {username}
          <SearchBar onSearch={handleSearch} />
        </div>
      </div>
      <button onClick={createPost} className="create-post-button">
        Add New Post
      </button>

      <ul>
        {noResult ? (
          <div className="no-result-message">No results found.</div>
        ) : filteredPosts.length > 0 ? (
          filteredPosts.map((post) => (
            <div className="post" key={post.id}>
              <li className="post-content">{post.post_data}</li>
              <div className="post-author">Created by: {post.user.name}</div>
              <input
                type="text"
                name=""
                id="commentid"
                onChange={(e) => {
                  setNewComment(e.target.value);
                }}
              />
              <button id="comment-button" onClick={() => addcomment(post.id)}>
                Add comment
              </button>
              <div>
                Comments:
                <ul>
                  {post.commentlist.map((comment) => (
                    <div key={comment.id} className="comment-box">
                      <div className="comment-author">Comment Author: {comment.user.name}</div>
                      <div className="comment-content">
                        <div className="comment-text">{comment.comment_data}</div>
                      </div>
                    </div>
                  ))}
                </ul>
              </div>
            </div>
          ))
        ) : (
          posts.map((post) => (
            <div className="post" key={post.id}>
              <li className="post-content">{post.post_data}</li>
              <div className="post-author">Post Author: {post.user.name}</div>
              <input
                type="text"
                name=""
                id="commentid"
                onChange={(e) => {
                  setNewComment(e.target.value);
                }}
              />
              <button id="comment-button" onClick={() => addcomment(post.id)}>
                Add comment
              </button>
              <div>
                Comments:
                <ul>
                  {post.commentlist.map((comment) => (
                    <div key={comment.id} className="comment-box">
                      <div className="comment-author">Comment Author: {comment.user.name}</div>
                      <div className="comment-content">
                        <div className="comment-text">{comment.comment_data}</div>
                      </div>
                    </div>
                  ))}
                </ul>
              </div>
            </div>
          ))
        )}
      </ul>

      <div className="login-footer">
        <div>Created By:</div>
        <div className="user-name">Harsh Sharma</div>
        <div className="linkedin-link">
          <a href="https://www.linkedin.com/in/harsh-sharma-11dec1995/" target="_blank" rel="noopener noreferrer">
            LinkedIn Profile
          </a>
        </div>
      </div>
    </div>
  );
};

export default Home;
