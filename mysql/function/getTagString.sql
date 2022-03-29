delimiter //
drop function if exists getTagString;

create function getTagString(p_post_id int) returns varchar(4000)

begin

    declare result varchar(4000) default '';

    declare temp varchar(100) default '';
    declare endOfRow boolean default false;
    declare tagCursor cursor for
select tag_name from tag where post_id = p_post_id;
declare continue handler for not found  set endOfRow = true;

open tagCursor;
my_loop: LOOP

        fetch tagCursor into temp;

        if endOfRow then
            leave my_loop;
end if;

        set result = concat(result,'#',temp,' ');

END LOOP my_loop;

close tagCursor;

return result;

end //;
delimiter ;