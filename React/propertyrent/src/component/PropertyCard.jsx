import React, { useEffect, useState } from 'react';
import { Row, Col, Card, CardImg, CardBody, CardSubtitle, CardText, CardTitle, Container } from 'reactstrap';
import pic from '../images/auth.svg';
import about3 from '../images/about14.jpg';
import getservice from '../service/getPropertyApi';

export default function PropertyCard() {
    const [Property, setProprty] = useState([]);
    const getdata = () => {
        fetch('http://localhost:8080/')
        .then((res) => res.json())
        .then((res) => {
          console.log(res)
          setProprty(res)
        })
    }
    useEffect(() => {
        getdata()
    },[])
    return (
        <>
            <Container>
                <Row>
                    <div className="item-heading-left">
                        <span className="section-subtitle">Our PROPERTIES</span>
                        <h2 className="section-title">Latest Properties</h2>
                    </div>
                </Row>
                <Row>
                    {Property.map((item) => {
                        console.log(item);
                    <Col>
                        <Card style={{ width: '28rem' }}>
                            <CardImg
                                alt="Card image cap"
                                src={about3}
                                width="100%" />
                            <CardBody style={{ padding: 20 }}>
                                <CardTitle tag="h3">
                                    {item.property_name}
                                </CardTitle>
                                <CardSubtitle style={{ padding: '10px 10px 10px 0px' }}
                                    className="mb-2 text-muted"
                                    tag="h6">
                                    <i class="fa fa-map-marker"></i> Surat
                                </CardSubtitle>
                                <CardText>
                                    <ul style={{ display: 'flex', justifyContent: 'space-between', padding: '0' }}>
                                        <li><i class="fa fa-bed"></i> Beds: 03</li>
                                        <li style={{ float: 'right' }}><i class="fa fa-bath"></i> Baths: 02</li>
                                    </ul>
                                </CardText>
                            </CardBody>
                        </Card>
                    </Col>
                    })}
                </Row>
            </Container>
        </>
    )
}