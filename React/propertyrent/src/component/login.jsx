import React from 'react'
import { Button, Form, FormGroup, Input, Row, Container, Col } from 'reactstrap';
import Header from './header';
import { Link } from 'react-router-dom';
import pic from '../images/auth.svg';

export default function login() {
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
                  <Input type="email" id="email" placeholder="Email id" />
                </FormGroup>
                <FormGroup>
                  <Input type="password" id="password" placeholder="Password" />
                </FormGroup>

                <Button>Login</Button>
                {/* <FormGroup> */}
                <Row className='mt-3'>
                  <Col>
                    <Link to="/" className='signinlink'> New User ? </Link>
                  </Col>
                </Row>

                {/* </FormGroup> */}
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
