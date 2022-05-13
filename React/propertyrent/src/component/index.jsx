import React from 'react'
import { Container, Row, Col } from 'reactstrap';
import Banner from '../images/slider4.jpg';

export default function index() {
    return (
        <section style={{ backgroundImage: `url(${Banner})` }} className="banner">
            <Container>
                <Row>
                    <div className="main-banner-box1  main-banner-box5">
                        <h1 class="item-title wow fadeInUp" data-wow-delay=".4s">Let's find the perfect place</h1>
                        <ul class="list-inline">
                            <li>
                                <label for="apartments" class="active">
                                    <i class="fa fa-building active"></i>
                                    <span>Apartments</span>
                                    {/* <input checked="" type="radio" name="rtcl_category" id="apartments" value="apartments"/> */}
                                </label>
                            </li>
                            <li>
                                <label for="home">
                                    <i class="fa fa-home"></i>
                                    <span>Home</span>
                                    {/* <input checked="" type="radio" name="rtcl_category" id="home" value="home"/> */}
                                </label>
                            </li>
                            <li>
                                <label for="office">
                                    <i class="fa fa-briefcase"></i>
                                    <span>Office</span>
                                    {/* <input checked="" type="radio" name="rtcl_category" id="office" value="office"/> */}
                                </label>
                            </li>
                            <li>
                                <label for="shop">
                                    <i class="fa fa-shopping-basket"></i>
                                    <span>Shop</span>
                                    {/* <input checked="" type="radio" name="rtcl_category" id="shop" value="shop"/> */}
                                </label>
                            </li>
                        </ul>
                        <div class="banner-search-wrap">
                            <div class="rld-main-search">
                                <Row>
                                    <Col>
                                        <div class="box">
                                            <div class="box-top">
                                                <div class="rld-single-input item">
                                                    <input type="text" placeholder="Enter Kewword here..." />
                                                </div>
                                                <div class="rld-single-select ml-22">
                                                    <select class="select single-select">
                                                        <option value="1">Property Type</option>
                                                        <option value="2">Family House</option>
                                                        <option value="3">Apartment</option>
                                                        <option value="3">Condo</option>
                                                    </select>
                                                </div>
                                                <div class="rld-single-select item">
                                                    <select class="select single-select mr-0">
                                                        <option value="1">All Cities</option>
                                                        <option value="2">Los Angeles</option>
                                                        <option value="3">Chicago</option>
                                                        <option value="3">Philadelphia</option>
                                                    </select>
                                                </div>
                                                <div class="item rt-filter-btn">
                                                    <div class="dropdown-filter item">
                                                        <span>
                                                            <i class="fas fa-sliders-h"></i>
                                                        </span>
                                                    </div>
                                                    <div class="filter-button-area">
                                                        <a class="filter-btn" href="with-sidebar.html"><span>Search</span><i
                                                            class="fa fa-search"></i></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </Col>
                                </Row>
                            </div>
                        </div>
                        <p class="item-para wow fadeInUp" data-wow-delay=".4s">We’ve more than <span
                            class="banner-p">54,000</span> apartments, place & plot.
                        </p>
                        {/* </div> */}
                    </div>
                </Row>
            </Container>
        </section>

    )
}
