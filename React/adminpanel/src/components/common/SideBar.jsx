import React from 'react'
import "../../css/style.css"
import { Container, Row, Col } from "reactstrap"
import * as AiIcons from "react-icons/ai"
import {Link} from 'react-router-dom';
import * as GiIcons from "react-icons/gi";
import * as BiIcons from "react-icons/bi";
import * as FaIcons from "react-icons/fa";
import * as MdIcons from "react-icons/md";
import * as CgIcons from "react-icons/cg";

function SideBar() {
  return (
    <React.Fragment>
      <section id="sidebar">
        <h1 className="logo-name">RentOut.com</h1>
        <ul className="nav-links">
          <li>
            <Link to="/role">
              <BiIcons.BiUserPlus size={40} style={{color:"white" , marginRight:"10px"}}/>
              <span className="link_name">Manage Role</span>
            </Link>
            </li>
          <li>
            <a href="/propertytypes">
            <GiIcons.GiHouse size={40} style={{color:"white" , marginRight:"10px"}}/>
              <span className="link_name">Manage Property Types</span>
            </a>
          </li>
          <li>
            <Link to="/amenities">
            <FaIcons.FaBed size={40} style={{color:"white" , marginRight:"10px"}}/>
            <span className="link_name">Manage Amenities</span>
            </Link>
          </li>
       
          <li>
            <a href="#">
            <FaIcons.FaFan size={40} style={{color:"white" , marginRight:"10px"}}/>
              <span className="link_name">Manage Sub Amenities</span>
            </a>
          </li>
          <li>
            <a href="#">
            <MdIcons.MdOutlineEventAvailable size={40} style={{color:"white" , marginRight:"10px"}}/>
              <span className="link_name">Manage Events</span>
            </a>
          </li>
          <li>
            <a href="#">
            <BiIcons.BiWorld size={40} style={{color:"white" , marginRight:"10px"}}/>
              <span className="link_name">Manage State</span>
            </a>
          </li>
          <li>
            <a href="#">
            <GiIcons.GiModernCity size={40} style={{color:"white" , marginRight:"10px"}}/>
              <span className="link_name">Manage City</span>
            </a>
          </li>
          <li>
            <a href="#">
            <CgIcons.CgProfile size={40} style={{color:"white" , marginRight:"10px"}}/>
              <span className="link_name">Manage Profile</span>
            </a>
          </li>
        </ul>
      </section>
    </React.Fragment>
  )
}

export default SideBar