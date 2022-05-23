import './App.css';
import Register from './component/home/Register';
import Login from './component/home/Login';
import About from './component/about/About';
import Header from './component/Header';
import Contact from './component/contact/Contact';
import Index from './component/home/Index';
import Property from './component/property/Property';
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
          <Route path='/property' element={<Property />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
