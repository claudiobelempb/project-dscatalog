import styled, { css } from 'styled-components';

export const LayoutContainer = styled.div`
  ${({ theme }) => css`
    max-width: 100%;
    height: 100%;
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
