import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
    name: 'truncate'
})
export class TruncatePipe implements PipeTransform{
    transform(value: String, length: number){
        return value.substring(0, length) + '...';
    }
}