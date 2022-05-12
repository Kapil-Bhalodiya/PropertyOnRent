// import './App.css';
import {BrowserRouter as Router,
        Route, 
        Routes} from 'react-router-dom';


import Register from './component/Register';
import Login from './component/Login';
import Header from './component/header';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path='/' exact element={<Header />} />
          
          <Route path='/login' element={<Login />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
