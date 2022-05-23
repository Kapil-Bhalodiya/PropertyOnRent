import React from 'react'
import "../css/style.css"
import {useState} from "react";
import { Container, Row, Col, Form, FormGroup, Input, Button, Label,Table } from "reactstrap"
import * as AiIcons from "react-icons/ai"
import axios from 'axios';
import SideBar from './common/SideBar';
import * as BiIcons from "react-icons/bi";
import * as FaIcons from "react-icons/fa";
import NavigationBar from './common/NavigationBar';
const Flag = 0;
function Role() {

    const [state, setState] = React.useState({
        role_name: ''
    })

    const handleChange = (e) => {
        setState(prevState => ({
            ...prevState,
            [e.target.name]: e.target.value
        }))
    }

    const handleSave = async (e)=>{
        e.preventDefault();
        let data = {
            role_name: state.role_name
      }
        let res = await axios.post(`http://localhost:3000/role/add`,data);
        console.log(res)
        fetchData();
      }

      const handleReset = async (e)=>{
        setState(prevState=>({
            ...prevState,
            role_name: ''
        }))
        fetchData();
      }

      const handleDelete = async (id)=>{
        
        let res = await axios.delete(`http://localhost:3000/role/delete/${id}`);
        console.log(res)
        fetchData();
      }

      const handleEdit = async (id)=>{
        let res = await axios.get(`http://localhost:3000/role/get/${id}`);
        // state.role_name = res.data.role_name;
        // handleChange.bind(state);
        setState(prevState=>({
            ...prevState,
            role_name: res.data[0].role_name
        }))
      }

      const updateData = async (id)=>{
        let res = await axios.put(`http://localhost:3000/role/edit/${id}`);
        console.log(res)
        fetchData();
      }

    const fetchData = async () => {
        let res = await axios.get(`http://localhost:3000/role/getall`);
        setData(res.data)
        console.log(res)
    }
    const [Data, setData] = useState([])
    React.useEffect(() => {
        fetchData();
    }, [])
  
    return (
        <React.Fragment>
            <SideBar/>
            <NavigationBar/>
            <main className='section-main'>
                <Container>
                    <Row className='input-panel'>
                        <h2 className='mb-4'><b>Role Details</b></h2> 
                        <hr/>
                        <Form>
                            <FormGroup>
                                <Col className='label-margin'><Label>Role Name</Label></Col> 
                                <Col><Input type="text" name="role_name" value={state.role_name} id="roleName" onChange={handleChange} placeholder="Enter Role Name"/></Col>
                            </FormGroup>
                            <Button onClick={handleSave} className="button-save">Save</Button>
                            <Button onClick={handleReset} className="button-reset">Reset</Button>
                        </Form>
                    </Row>
                    <Row  className='input-panel'>
                    <Table className='table-data'>
                        <thead>
                            <tr>
                                <th>
                                    Role Name
                                </th>
                                <th>
                                  Edit
                                </th>
                                <th>
                                   Delete
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                           {
                               Data.map(
                                   (entry,index)=>(
                                    <tr key={index}>
                                    <td>{entry.role_name}</td>
                                    <td align='center'>
                                        <Button onClick={()=>handleEdit(entry.role_id)} className='button-edit'>
                                                <BiIcons.BiEdit size={20} style={{color:"white"}}/>
                                        </Button>
                                    </td>
                                    <td align='center'>
                                        <Button onClick={()=>handleDelete(entry.role_id)} className='button-delete'>
                                            <AiIcons.AiFillDelete size={20} style={{color:"white",margin:"5%"}}/>
                                        </Button>
                                    </td>
                                    </tr>
                                   )
                               )
                           }
                        </tbody>
                    </Table>
                    </Row>
                </Container>
            </main>
        </React.Fragment>
    )
}
export default Role