i m p o r t   j a v a . a w t . C o l o r ; 
 i m p o r t   j a v a . a w t . S h a p e ; 
 i m p o r t   j a v a . a w t . R e c t a n g l e ; 
 i m p o r t   j a v a . a w t . G r a p h i c s ; 
 i m p o r t   j a v a x . s w i n g . I m a g e I c o n ; 
 
 / / a   B u t t o n   c l a s s   t h a t   h a s   d a t a   f i e l d s   a n d   a b i l i t i e s   f o r   d y n a m i c   b u t t o n s   i n   a   g a m e   c o m p a t i b l e   w i t h   a   M o u s e L i s t e n e r 
 p u b l i c   c l a s s   B u t t o n 
 { 
       p r i v a t e   S h a p e   s h a p e ;               / / W e   c a n   s e n d   a n y   c l a s s   t h a t   i m p l e m e n t s   j a v a . a w t . S h a p e   i n t e r f a c e 
       p r i v a t e   S t r i n g   t i t l e ;             / / T h e   t i t l e   i s   t h e   t e x t   w e   w a n t   d r a w n   i n   t h e   B u t t o n   ( i f   a n y ) . 
       p r i v a t e   C o l o r   c o l o r ,   r e g u l a r C o l o r ,   h i g h l i g h t C o l o r ,   t e x t C o l o r ; 
       / * c o l o r   i s   t h e   c u r r e n t   c o l o r   o f   t h e   B u t t o n   w h i c h   w i l l   c h a n g e   f r o m   r e g u l a r C o l o r   t o   h i g h l i g h t C o l o r   a s   t h e   m o u s e   m o v e s   o v e r   i t * / 
       p r i v a t e   I m a g e I c o n   i m a g e ,   r e g u l a r I m a g e ,   h i g h l i g h t I m a g e ; 
       / * u s i n g   g r a p h i c   i m a g e s   f o r   t h e   b u t t o n   i n s t e a d   o f   c o l o r * / 
       
       p u b l i c   B u t t o n ( S h a p e   s ,   S t r i n g   t ,   C o l o r   r c ,   C o l o r   h c ,   C o l o r   t c ) 
       { 
             s h a p e   =   s ; 
             t i t l e   =   t ; 
             r e g u l a r C o l o r   =   r c ; 
             h i g h l i g h t C o l o r   =   h c ; 
             t e x t C o l o r   =   t c ; 
             c o l o r   =   r e g u l a r C o l o r ; 
             r e g u l a r I m a g e   =   n u l l ; 
             h i g h l i g h t I m a g e   =   n u l l ; 
             i m a g e   =   n u l l ; 
       } 
       
       p u b l i c   B u t t o n ( S h a p e   s ,   S t r i n g   t ,   I m a g e I c o n   r i ,   I m a g e I c o n   h i ) 
       { 
             s h a p e   =   s ; 
             t i t l e   =   t ; 
             r e g u l a r C o l o r   =   n u l l ; 
             h i g h l i g h t C o l o r   =   n u l l ; 
             t e x t C o l o r   =   n u l l ; 
             r e g u l a r I m a g e   =   r i ; 
             h i g h l i g h t I m a g e   =   h i ; 
             i m a g e   =   r e g u l a r I m a g e ; 
       } 
       
       p u b l i c   S h a p e   g e t S h a p e ( ) 
       { 
             r e t u r n   s h a p e ; 
       } 
       
       p u b l i c   S t r i n g   g e t T i t l e ( ) 
       { 
             r e t u r n   t i t l e ; 
       } 
       
       p u b l i c   C o l o r   g e t C o l o r ( ) 
       { 
             r e t u r n   c o l o r ; 
       } 
       
       p u b l i c   C o l o r   g e t R e g u l a r C o l o r ( ) 
       { 
             r e t u r n   r e g u l a r C o l o r ; 
       } 
       
       p u b l i c   C o l o r   g e t H i g h l i g h t C o l o r ( ) 
       { 
             r e t u r n   h i g h l i g h t C o l o r ; 
       } 
       
       p u b l i c   C o l o r   g e t T e x t C o l o r ( ) 
       { 
             r e t u r n   t e x t C o l o r ; 
       } 
       
       p u b l i c   I m a g e I c o n   g e t I m a g e I c o n ( ) 
       { 
             r e t u r n   i m a g e ; 
       } 
       
       p u b l i c   I m a g e I c o n   g e t R e g u l a r I m a g e ( ) 
       { 
             r e t u r n   r e g u l a r I m a g e ; 
       } 
 
       p u b l i c   I m a g e I c o n   g e t H i g h l i g h t I m a g e ( ) 
       { 
             r e t u r n   h i g h l i g h t I m a g e ; 
       } 
 
 / * T h e s e   m e t h o d s   w i l l   b e   c a l l e d   i n   t h e   m o u s e M o v e d   m e t h o d   f r o m   t h e   M o u s e L i s t e n e r   i n t e r f a c e .     
 I f   t h e   m o u s e X   a n d   m o u s e Y   p o s i t i o n s   a r e   w i t h i n   t h e   B u t t o n  s   s h a p e ,   
 w e   c a n   c a l l   h i g h l i g h t ( )   w h i c h   c h a n g e s   t h e   c o l o r   t o   t h e   h i g h l i g h t C o l o r * / 
       p u b l i c   v o i d   h i g h l i g h t ( ) 
       { 
             c o l o r   =   h i g h l i g h t C o l o r ; 
             i m a g e   =   h i g h l i g h t I m a g e ; 
       } 
       
       p u b l i c   v o i d   u n H i g h l i g h t ( ) 
       { 
             c o l o r   =   r e g u l a r C o l o r ; 
             i m a g e   =   r e g u l a r I m a g e ; 
       } 
       
       p u b l i c   v o i d   d r a w B u t t o n ( G r a p h i c s   g ) 
       { 
             i n t   x   =   ( i n t ) ( t h i s . g e t S h a p e ( ) . g e t B o u n d s ( ) . g e t X ( ) ) ; 
             i n t   y   =   ( i n t ) ( t h i s . g e t S h a p e ( ) . g e t B o u n d s ( ) . g e t Y ( ) ) ; 
             i n t   w i d t h   =   ( i n t ) ( t h i s . g e t S h a p e ( ) . g e t B o u n d s ( ) . g e t W i d t h ( ) ) ; 
             i n t   h e i g h t   =   ( i n t ) ( t h i s . g e t S h a p e ( ) . g e t B o u n d s ( ) . g e t H e i g h t ( ) ) ; 
             g . s e t C o l o r ( t h i s . g e t C o l o r ( ) ) ; 	 
             i f ( i m a g e   ! =   n u l l ) 
                   g . d r a w I m a g e ( i m a g e . g e t I m a g e ( ) ,   x ,   y ,   w i d t h ,   h e i g h t ,   n u l l ) ;     
             e l s e   i f ( t h i s . g e t S h a p e ( )   i n s t a n c e o f   R e c t a n g l e )                   
                   g . f i l l R e c t ( x ,   y ,   w i d t h ,   h e i g h t ) ; 
             e l s e               
                   g . f i l l O v a l ( x ,   y ,   w i d t h ,   h e i g h t ) ; 
             i f ( i m a g e   = =   n u l l ) 
             {       
                   g . s e t C o l o r ( t h i s . g e t T e x t C o l o r ( ) ) ; 	                       
                   g . d r a w S t r i n g ( t h i s . g e t T i t l e ( ) ,   x + ( w i d t h / 4 ) ,   y + ( h e i g h t / 2 ) ) ; 
             } 
       } 
       
       p u b l i c   v o i d   s e t S h a p e ( S h a p e   s ) 
       { 
             s h a p e   =   s ; 
       } 
       
       p u b l i c   v o i d   s e t T i t l e ( S t r i n g   t ) 
       { 
             t i t l e   =   t ; 
       } 
       
       p u b l i c   v o i d   s e t R e g u l a r C o l o r ( C o l o r   r c ) 
       { 
             r e g u l a r C o l o r   =   r c ; 
       } 
                       
       p u b l i c   v o i d   s e t H i g h l i g h t C o l o r ( C o l o r   h c ) 
       { 
             h i g h l i g h t C o l o r   =   h c ; 
       } 
       
       p u b l i c   v o i d   s e t T e x t C o l o r ( C o l o r   t c ) 
       { 
             t e x t C o l o r   =   t c ; 
       } 
       
       p u b l i c   S t r i n g   t o S t r i n g ( ) 
       { 
             R e c t a n g l e   r   =   s h a p e . g e t B o u n d s ( ) ; 
             r e t u r n   " X : " + r . g e t X ( ) + " , Y : " + r . g e t Y ( ) + "   " + t i t l e + " \ n C o l o r : " + r e g u l a r C o l o r + "   H i g h l i g h t " + h i g h l i g h t C o l o r + "   t e x t " + t e x t C o l o r ;   
       } 
 } 