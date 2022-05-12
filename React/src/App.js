import './App.css';
import Register from './component/register';
import Login from './component/login';
import About from './component/about';
import Header from './component/header';
import Contact from './component/contact';
import Index from './component/index';
import {
  BrowserRouter as Router,
  Route,
  Routes
} from 'react-router-dom';



function App() {
  return (
    <>
      <Router>
      <Header />
        <Routes>
          <Route path='/' exact element={<Index />} />
          <Route path='/register' element={<Register/>} />
          <Route path='/login' element={<Login />} />
          <Route path='/about' element={<About />} />
          <Route path='/contact' element={<Contact />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
