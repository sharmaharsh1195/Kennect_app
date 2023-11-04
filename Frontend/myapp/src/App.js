
import './App.css';
import UserLogin from './Components/UserLogin';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './Components/Home';
import CreatePost from './Components/CreatePost';


function App() {
  return (
    <>
    <Router>
      <Routes>
      <Route path="/home/:username" element={<Home />} />
      <Route path="/" element={<UserLogin />} />
      <Route path="/createpost/:username" element={<CreatePost />} />
      </Routes>
    </Router>

    </>
  );
}

export default App;
