PGDMP     -                    y           DBEstudiante    13.4    13.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16416    DBEstudiante    DATABASE     k   CREATE DATABASE "DBEstudiante" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Mexico.1252';
    DROP DATABASE "DBEstudiante";
                postgres    false            �          0    16427 
   estudiante 
   TABLE DATA           e   COPY public.estudiante (idestudiante, primer_nom, seg_nom, primer_ape, seg_ape, estatus) FROM stdin;
    public          postgres    false    201          �           0    0    estudiante_idestudiante_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.estudiante_idestudiante_seq', 27, true);
          public          postgres    false    200            �   �   x�=��
�@�����A�XjQK��Kt�׍d��z�^r�y���D����+vj3'�"E�4�,���.�mh�LBPr56M�Х'O������%Y��)e��7����Y��/l�^���BNl�A_�#��e���%?_     