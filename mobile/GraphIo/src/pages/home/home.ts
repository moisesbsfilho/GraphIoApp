import { Component, OnInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Apollo } from 'apollo-angular';
import gql from 'graphql-tag';

const AllPosts = gql`
  query{
    allPosts{
      id
      imageUrl
      description
      comments{
        description
      }
    }
  }
`;

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage implements OnInit{

  public posts: Array<string>;

  public showPostId: Number;

  public allOpenedComments: Array<Number> = new Array<Number>();

  constructor(public navCtrl: NavController, private appolo: Apollo) { }

  public showComments(event, post): void {
    if(this.allOpenedComments.includes(post.id)){
      const index: number = this.allOpenedComments.indexOf(post.id);
      console.log(index);
      this.allOpenedComments.splice(index, 1);
    }
    else
      this.allOpenedComments.push(post.id);
  }

  ngOnInit(){
    this.appolo.watchQuery({
      query: AllPosts
    }).subscribe(({data}) => {
      this.posts = data.allPosts;
    });
  }

}
