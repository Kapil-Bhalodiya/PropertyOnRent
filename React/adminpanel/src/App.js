import React from 'react';
import SideBar from './components/common/SideBar';
import Role from './components/Role';
import { BrowserRouter, Routes,Route } from 'react-router-dom'
import Amenities from './components/Amenities';
import PropertyTypes from './components/PropertyTypes';
import Login from './components/Login';

function App() {
  return (
    <React.Fragment>
      <BrowserRouter>
      <Routes>
        <Route path="/login" element = {<Login/>}/>
        <Route path = "/role" element = {<Role/>}/>
        <Route path = "/amenities" element = {<Amenities/>}/>
        <Route path = "/propertytypes" element = {<PropertyTypes/>}/>
      </Routes>
      </BrowserRouter>
    </React.Fragment>
  );
}
export default App;
