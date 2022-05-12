import React from 'react'
import { Container, Row } from 'reactstrap';
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
                                <div class="row">
                                    <div class="col-sm-12">
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
                                                            class="fas fa-search"></i></a>
                                                    </div>
                                                </div>
                                            </div>
                                            </div>
                                            {/* <div class="explore__form-checkbox-list full-filter">
                                                <div class="row">
                                                    <div class="col-lg-4 col-md-6 py-1 pr-30 pl-0">
                                                        <div class="form-group bed">
                                                            <label class="item-bedrooms">Bedrooms</label>
                                                            <div class="nice-select form-control wide" tabindex="0">
                                                                <span class="current">Any</span>
                                                                <ul class="list">
                                                                    <li data-value="1" class="option selected ">For
                                                                        Sale</li>
                                                                    <li data-value="2" class="option">For Rent</li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-4 col-md-6 py-1 pr-30 pl-0 ">
                                                        <div class="form-group bath">
                                                            <label class="item-bath">Bathrooms</label>
                                                            <div class="nice-select form-control wide" tabindex="0">
                                                                <span class="current">Any</span>
                                                                <ul class="list">
                                                                    <li data-value="1" class="option selected">1
                                                                    </li>
                                                                    <li data-value="2" class="option">2</li>
                                                                    <li data-value="3" class="option">3</li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-4 col-md-6 py-1 pl-0 pr-0">
                                                        <div class="form-group garage">
                                                            <label class="item-garage">Garage</label>
                                                            <div class="nice-select form-control wide" tabindex="0">
                                                                <span class="current">Any</span>
                                                                <ul class="list">
                                                                    <li data-value="1" class="option selected">1
                                                                    </li>
                                                                    <li data-value="2" class="option">2</li>
                                                                    <li data-value="3" class="option">3</li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="main-search-field-2 col-12">
                                                        <div class="row">
                                                            <div class="col-md-6 pl-0">
                                                                <div class="price-range-wrapper">
                                                                    <div class="range-box">
                                                                        <div class="price-label">Flat Size:</div>
                                                                        <div id="price-range-filter-3"
                                                                            class="price-range-filter"></div>
                                                                        <div
                                                                            class="price-filter-wrap d-flex align-items-center">
                                                                            <div class="price-range-select">
                                                                                <div class="price-range"
                                                                                    id="price-range-min-3"></div>
                                                                                <div class="price-range">-</div>
                                                                                <div class="price-range"
                                                                                    id="price-range-max-3"></div>
                                                                                <div
                                                                                    class="price-range range-title">
                                                                                    sft</div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6 pl-0">
                                                                <div class="price-range-wrapper">
                                                                    <div class="range-box">
                                                                        <div class="price-label">Distance:</div>
                                                                        <div id="price-range-filter-2"
                                                                            class="price-range-filter"></div>
                                                                        <div
                                                                            class="price-filter-wrap d-flex align-items-center">
                                                                            <div class="price-range-select">
                                                                                <div class="price-range"
                                                                                    id="price-range-min-2"></div>
                                                                                <div class="price-range">-</div>
                                                                                <div class="price-range"
                                                                                    id="price-range-max-2"></div>
                                                                                <div
                                                                                    class="price-range range-title">
                                                                                    km</div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    {/* <div class="row">

                                                            <div class="col-lg-12 col-md-12 col-sm-12">
                                                                <h4 class="text-dark">Amenities</h4>
                                                                <ul class="no-ul-list third-row">
                                                                    <li>
                                                                        <input id="a-1" class="checkbox-custom"
                                                                            name="a-1" type="checkbox">
                                                                        <label for="a-1"
                                                                            class="checkbox-custom-label">Air
                                                                            Condition</label>
                                                                    </li>
                                                                    <li>
                                                                        <input id="a-2" class="checkbox-custom"
                                                                            name="a-2" type="checkbox">
                                                                        <label for="a-2"
                                                                            class="checkbox-custom-label">Bedding</label>
                                                                    </li>
                                                                    <li>
                                                                        <input id="a-3" class="checkbox-custom"
                                                                            name="a-3" type="checkbox">
                                                                        <label for="a-3"
                                                                            class="checkbox-custom-label">Heating</label>
                                                                    </li>
                                                                    <li>
                                                                        <input id="a-4" class="checkbox-custom"
                                                                            name="a-4" type="checkbox">
                                                                        <label for="a-4"
                                                                            class="checkbox-custom-label">Internet</label>
                                                                    </li>
                                                                    <li>
                                                                        <input id="a-5" class="checkbox-custom"
                                                                            name="a-5" type="checkbox">
                                                                        <label for="a-5"
                                                                            class="checkbox-custom-label">Microwave</label>
                                                                    </li>
                                                                    <li>
                                                                        <input id="a-6" class="checkbox-custom"
                                                                            name="a-6" type="checkbox">
                                                                        <label for="a-6"
                                                                            class="checkbox-custom-label">Smoking
                                                                            Allow</label>
                                                                    </li>
                                                                    <li>
                                                                        <input id="a-7" class="checkbox-custom"
                                                                            name="a-7" type="checkbox">
                                                                        <label for="a-7"
                                                                            class="checkbox-custom-label">Terrace</label>
                                                                    </li>
                                                                    <li>
                                                                        <input id="a-8" class="checkbox-custom"
                                                                            name="a-8" type="checkbox">
                                                                        <label for="a-8"
                                                                            class="checkbox-custom-label"/>Balcony</label>
                                                                    </li>
                                                                    <li>
                                                                        <input id="a-9" class="checkbox-custom"
                                                                            name="a-9" type="checkbox">
                                                                        <label for="a-9"
                                                                            class="checkbox-custom-label">Balcony</label>
                                                                    </li>
                                                                </ul>
                                                            </div>

                                                        </div> 
                                                    <div class="filter-button">
                                                        <a href="index3.html" class="filter-btn1">Apply Filter</a>
                                                        <a href="index3.html" class="filter-btn1 reset-btn">Reset Filter<i
                                                            class="fas fa-redo-alt"></i></a>
                                                    </div>
                                                </div>
                                            </div> */}
                                        </div>
                                    </div>
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
