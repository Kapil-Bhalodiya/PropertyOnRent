import React from 'react';
import pic from '../images/aa.svg';
import avater from '../images/avatar.svg';

function login() {
    return (
        <>
        <div className='container'>
            <div className='row col-12'>
                <div className='col-6'>
                    <img src={pic} className="img-fluid rounded w-auto" alt='img'/>
                </div>
                <div className='col-6 m-auto'>
                    <form className='form'>
                        <div className='col-3 w-auto'>
                            <img src={avater} className="img rounded mx-auto" height="200" alt='img'/>
                        </div>
                        <div class="form-groupl m-5">
                            <input type="text" className="form-control" placeholder="Username" />
                        </div>
                        <div className='form-group m-5 mb-3'>
                            <input type="password" className='form-control' name='password' placeholder='Password' />
                        </div>
                        <div className='form-group m-3'>
                            <a href='/'>Forget Password?</a>
                        </div>
                        <div>
                            <button className='btn btn-success'>Log in</button>
                        </div>
                    </form>
                </div>      
            </div>
        </div>
        </>
    )
}

export default login;