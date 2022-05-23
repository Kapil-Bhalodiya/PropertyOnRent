import React from 'react'
import { Button, Form, FormGroup, Label, Input, Row, Container, Col } from 'reactstrap';
import pic from '../../images/authentication/aa.svg';
import { Link } from 'react-router-dom';


export default function register() {
    return (
        <>
            <section className='section-reg'>
                <Container>
                    <Row className='row-reg'>
                    <Col className='col-6'>
                        <h2 className='h2 mb-4'><b>Registration</b></h2>
                        <hr/>
                            <Form>
                                <FormGroup tag="fieldset">
                                    <Row>
                                        <Col> <Label check>
                                            <Input type="radio" name="role" />{' '}
                                            User
                                        </Label></Col>
                                        <Col> <Label check>
                                            <Input type="radio" name="role" />{' '}
                                            Vendor
                                        </Label></Col>
                                    </Row>
                                </FormGroup>
                                <FormGroup>
                                    <Row>
                                        <Col>
                                            <Input type="text" id="firstname" placeholder="Firstname" />
                                        </Col>
                                        <Col>
                                            <Input type="text" id="lastname" placeholder="Lastname" />

                                        </Col>
                                    </Row>
                                </FormGroup>
                                <FormGroup>
                                    <Input type="email" id="email" placeholder="Email id" />
                                </FormGroup>
                                <FormGroup>
                                    <Input type="password" id="password" placeholder="Password" />
                                </FormGroup>
                                <FormGroup>
                                    <Input type="password" id="repassword" placeholder="Confirm Password" />
                                </FormGroup>
                                <FormGroup>
                                    <Row>
                                        <Col>
                                            <Input type="select" id="state">
                                                <option selected>Select State</option>
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </Input>
                                        </Col>
                                        <Col>
                                            <Input type="select" id="city">
                                                <option selected>Select City</option>
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </Input>
                                        </Col>
                                    </Row>
                                </FormGroup>
                                <Button>Submit</Button>
                                <Row className='mt-3'>
                                    <Col>
                                        <Link to="/login" className='signinlink'> Already User ? </Link>
                                    </Col>
                                </Row>
                            </Form>
                        </Col>
                         <Col className='col-6'>
                            <img src={pic} className='img-fluid' />
                        </Col>
                    </Row>
                </Container>
            </section>
            
        </>

    )
}
