import React from "react";
import logo from '../images/logo_light.svg';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../mycss.css';
import {
    Row,
    Navbar,
    NavItem,
    NavbarToggler,
    Collapse,
    NavLink,
    Nav,
    NavbarBrand,
    Container,
    Col
} from 'reactstrap';
import { NavLink as Link } from "react-router-dom";

function Header() {

    // Collapse isOpen State
    const [isOpen, setIsOpen] = React.useState(true);
    return (
        <section className="main-header">
            <div className="menu-layout">
           
            <Container>
                <Row className="menu-row"> 
                    <Navbar expand="md">
                        <NavbarBrand>
                            <img src={logo} className="img-fluid"/>
                        </NavbarBrand>
                        <NavbarToggler onClick={() => { setIsOpen(!isOpen) }} />
                        <Collapse isOpen={isOpen} navbar>
                            <Nav className="mr-auto menu-list" navbar>
                                <NavItem>
                                <NavLink tag={Link} to="/" activaClassName = "active">Home</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink tag={Link} to="/about" activaClassName = "active">About</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink tag={Link} to="/contact" activaClassName = "active">Contact</NavLink>
                                </NavItem>
                            </Nav>
                        </Collapse>
                        {/* <Col className="actionlist col-3 flex-end">
                           <ul>
                               <li>
                                <a>Sign in <i class="material-icons">person_filled</i></a>
                               </li>
                           </ul>
                        </Col> */}
                    </Navbar>
                </Row>
            </Container>
            </div>
        </section>
    );
}
export default Header;
