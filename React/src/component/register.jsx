import React from 'react';
import pic from '../images/auth.svg';

function register(props) {
    return (
        <>
            <div className='container'>
                <div className='row col-12'>
                    <div className='col-6 m-auto'>
                        <img src={pic} className="img-fluid rounded w-auto" alt='img' />
                    </div>
                    <div className='col-6 m-auto mt-5 shadow p-3 mb-5 bg-white rounded'>
                        <h2 className='mb-3'>Sign Up</h2>
                        <form className='form'>
                            <div className='row col-12'>
                                <div class="col-6">
                                    <div class="form-check form-check-inline">
                                        <input type="radio" id="user" name="role" className="form-check-input" />
                                        <label>User</label>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-check form-check-inline">
                                        <input type="radio" id="vendor" name="role" className="form-check-input" />
                                        <label>Vendor</label>
                                    </div>
                                </div>
                            </div>
                            <div className='row col-12'>
                                <div class="form-group col-6">
                                    <input type="text" id="firstName" className="form-control m-2" placeholder="Firstname" />
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" id="lastName" className="form-control m-2" placeholder="Lastname" />
                                </div>
                            </div>
                            <div className='row col-12'>
                                <div className='form-group'>
                                    <input type="number" className='form-control m-2' placeholder='Contact Number' />
                                </div>
                            </div>
                            <div className='row col-12'>
                                <div className='form-group'>
                                    <input type="email" className='form-control m-2' placeholder='Email id' />
                                </div>
                            </div>
                            <div className='row col-12'>
                                <div className='form-group'>
                                    <input type="text" className='form-control m-2' placeholder='Password' />
                                </div>
                            </div>
                            <div className='row col-12'>
                                <div className='form-group'>
                                    <input type="text" className='form-control m-2' placeholder='Confirm Password' />
                                </div>
                            </div>
                            <div className='row col-12'>
                                <div className='form-group col-6'>
                                    <select class="form-select m-2">
                                        <option selected>Select State</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                </div>
                                <div className='form-group col-6'>
                                    <select class="form-select m-2">
                                        <option selected>Select City</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                </div>
                            </div>
                            <div>
                                <button className='btn btn-success m-3'>Sign Up</button>
                            </div>
                            <div className='form-group m-3'>
                                <a href='/'>Already User?</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </>
    )
}

export default register
