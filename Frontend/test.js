import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';

const Home = () => {
  const { username } = useParams();
  const [posts, setPosts] = useState([]);
  const [comments, setComments] = useState([]);
  const [newcomment, setNewComment] = useState('');
  const [postOwner,setPostOwner]=useState('');

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
      });
      
      setNewComment('');
    } catch (err) {
      console.error(err);
    }
    getAllComments();
  };

  

  return (
    <div>
      <div>
        This is the home page, welcome {username}
      </div>

      <button onClick={createPost}>Click here for a new post</button>

      <ul>
        {posts.map(post => (
          <>
          {console.log(post)}
          <div key={post.id}>
            <li>{post.post_data}</li>
            <div>
              Comments:
              <ul>
                {post.commentlist.map(comment => (
                  <li key={comment.id}>{comment.comment_data}
                  <div>
                    created by -
                    </div></li>
                ))}
              </ul>
              <input
                type="text"
                name=""
                id="commentid"
                onChange={(e) => {
                  setNewComment(e.target.value);
                }}
              />
              <button onClick={() => addcomment(post.id)}>
                add comment
              </button>
            </div>
          </div>
        </>))}
      </ul>

      <div>
        <button onClick={showpost}>Show All Posts</button>
      </div>
    </div>
  );
};

export default Home;
