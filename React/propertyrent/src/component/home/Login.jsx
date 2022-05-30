import React,{useState} from 'react'
import { Button, Form, FormGroup, Input, Row, Container, Col } from 'reactstrap';
import pic from '../../images/authentication/auth.svg';
import { Link, useNavigate } from 'react-router-dom';

const Login = () => {

  const [state,setState] = React.useState({
    emailId:'',
    password:''
  })

  const navigate = useNavigate();

  const handleChange = (e) =>{
    setState(prevState=>({
      ...prevState,
      [e.target.name]:e.target.value
    }))
  }

  const handleLogin = async (e)=>{
    e.preventDefault();
    let data = {
      emailId: state.emailId,
      password: state.password
  }
    let res = await fetch('http://localhost:8080/login',data);
    console.log(res);
    navigate("/role");
  }


  return (
    <>
      <section className='section-reg'>
        <Container>
          <Row className='row-reg'>
            <Col>
              <h2 className='h2 mb-4'><b>Sign In</b></h2>
              <hr />
              <Form>
                <FormGroup>
                  <Input type="email" name="emailId" value={state.emailId} id="email" onChange={handleChange} placeholder="Email id" />
                </FormGroup>
                <FormGroup>
                  <Input type="password" name="password" value={state.password} id="password" onChange={handleChange} placeholder="Password" />
                </FormGroup>
                <Button onClick={handleLogin} >Login</Button>
                <Row className='mt-3'>
                  <Col>
                    <Link to="/register" className='signinlink'> New User ? </Link>
                  </Col>
                </Row>
              </Form>
            </Col>
            <Col>
              <img src={pic} className='img-fluid'/>
            </Col>
          </Row>
        </Container>
      </section>
    </>
  )
}
export default Login;