import React from "react";
import pic from '../images/slider4.jpg';
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
    Container
} from 'reactstrap';

function Header() {

    // Collapse isOpen State
    const [isOpen, setIsOpen] = React.useState(true);

    return (
        <section className="main-header">
            <div className="menu-layout">
            <Container>
                <Row className="menu-row"> 
                    <Navbar expand="sm">
                        <NavbarBrand>
                            <img src={logo} />
                        </NavbarBrand>
                        <NavbarToggler onClick={() => { setIsOpen(!isOpen) }} />
                        <Collapse isOpen={isOpen} navbar>
                            <Nav className="mr-auto menu-list" navbar>
                                <NavItem>
                                    <NavLink href="index.html">Home</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink href="index.html" className="active">About</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink href="#">Contact</NavLink>
                                </NavItem>
                            </Nav>
                        </Collapse>
                    </Navbar>
                </Row>
            </Container>
            </div>
        </section>
    );
}

export default Header;
// function Header() {
//     return (
//         <React.Fragment>
//             <section className="main-header">
//                 <Container>
//                     <Row>
//                         <Col className="col-2">
//                             <img src={logo} />
//                         </Col>
//                         <Col className="col-6 menu">
//                             <ul>
//                                 <li>
//                                     <a href="index.html">Home</a>
//                                 </li>
//                                 <li>
//                                     <a href="about-1.html" >About</a>
//                                 </li>
//                                 <li>
//                                     <a href="with-sidebar2.html" class="active">Property</a>
//                                 </li>
//                                 <li>
//                                     <a href="contact.html">Contact</a>
//                                 </li>
//                             </ul>
//                         </Col>
//                     </Row>
//                 </Container>
//             </section>
//         </React.Fragment>
//     )
// }
// export default Header