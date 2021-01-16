import React from 'react';
class Ap extends React.Component{
    constructor(props){
        super(props);
        this.state={
            userlogs : ["login",
                        "id",
                        "node_id",
                        "url",
                        "repos_url",
                        "events_url",
                        "hooks_url",
                        "issues_url",
                        "members_url",
                        "public_members_url",
                        "avatar_url",
                        "description",""],
            user:[],
            isFetching:true
        };
        this.fetchtheAPI();
    }
    async fetchtheAPI(){
        this.setState({...this.state,isFetching:true});
        await fetch('https://api.github.com/users/hadley/orgs')
        .then(response => response.json())
        .then(result=>{
            this.setState({...this.state,user:result,isFetching:false});
            console.log(this.state.user);
        })
        .catch(e=>{
            console.log(e);
            this.setState({...this.state,user:[],isFetching:false});
        });
    };
     renderTableHeader(){
      return this.state.userlogs.map((key, index) => {
          return <th key={index}>{key}</th>
      })
    }
    
    renderTableData() {
        const deleting = (id) => {
        console.log(document.getElementById(id));
        document.getElementById(id).remove();
    };
        return this.state.user.map((user, index) => {
         const {login,id,node_id,url,repos_url,events_url,hooks_url,issues_url,members_url,public_members_url,avatar_url,description} = user;
         return (
            <tr id={id} key={id}>
               <td>{login}</td>
               <td>{id}</td>
               <td>{node_id}</td>
               <td>{url}</td>
               <td>{repos_url}</td>
               <td>{events_url}</td>
               <td>{hooks_url}</td>
               <td>{issues_url}</td>
               <td>{members_url}</td>
               <td>{public_members_url}</td>
               <td>{avatar_url}</td>
               <td>{description}</td>
               <td>
                   <button onClick={()=>deleting(id)}>x</button>
               </td>
            </tr>
         )
      })
   }
   render() {
      return (
         <div>
            <h1 id='title'>React ApiCall</h1> { (this.state.isFetching)? 'loading...':null }
            <table id='user' border="1">
               <thead>
               <tr>{this.renderTableHeader()}</tr>
               </thead>
               <tbody>
                  {this.renderTableData()}
               </tbody>
            </table>
         </div>
      )
   }
}

export default Ap